/**
 * Merge defaults with user options
 * @private
 * @param {Object} defaults Default settings
 * @param {Object} options User options
 * @returns {Object} Merged values of defaults and options
 */
var extend = function ( defaults, options ) {
    var extended = {};
    var prop;
    for (prop in defaults) {
        if (Object.prototype.hasOwnProperty.call(defaults, prop)) {
            extended[prop] = defaults[prop];
        }
    }
    for (prop in options) {
        if (Object.prototype.hasOwnProperty.call(options, prop)) {
            extended[prop] = options[prop];
        }
    }
    return extended;
};

/**
 * Classe pour la carte Google Maps
 */
function Maps(initial_options) {

	this.global_maps_map;
	this.global_maps_geocoder;
	this.global_maps_bounds;
	this.global_maps_markersArray = [];
	this.global_maps_directions = [];
	this.global_maps_directions_nbrequests = 0;
	this.global_maps_directions_nbresponses = 0;
	this.global_data = { places: [], total_distance: 0 };
	this.global_delay_check;
	this.id;
	
	this.options_defaults = {
		infosbulles: true,
		itineraires: false, // itinéraire entre les markers
		delai_survol: 600 // en ms
	};
	this.options = extend(this.options_defaults, initial_options);

	
	this.colors = [
		// couleur1, couleur2, texte
		['ff0000', 'ff7575', '000000'], // rouge
		['c56b2e', 'c6926f', 'ffffff'], // marron
		['ff9800', 'ffc878', '000000'], // orange
		['f6ff00', 'fbff86', '000000'], // jaune
		['58ff00', 'affa88', '000000'], // vert citron
		['7cae40', 'a7c97e', '000000'], // kaki
		['23961f', '69d965', '000000'], // vert
		['1ed098', '75d7b8', '000000'], // bleu vert
		['06ccf5', '83dff2', '000000'], // bleu ciel
		['486282', '819fc3', '000000'], // bleu grisé
		['0654f5', '8db2ff', 'ffffff'], // bleu foncé
		['8806f5', 'c689f9', 'ffffff'], // violet
		['894694', 'ad71b6', 'ffffff'], // mauve
		['f506e3', 'f296eb', 'ffffff'], // rose
		['f5067c', 'ff86c2', 'ffffff'], // fushia
		['b3b3b3', 'd3d3d3', '000000'], // gris clair
		['6a6a6a', '9c9c9c', 'ffffff'], // gris moyen
		['000000', '535353', 'ffffff'], // noir
		// ne pas changer la liste couleur1 (ou alors refaire l'icone aussi)
	];
	
	if( typeof Maps.initialized == "undefined" ) { 

		Maps.prototype.id = 0;
		
		Maps.prototype.getId = function() {
			return this.id;
		};
		
		/**
		 * Récupérer l'url d'une icône Google.
		 * Appelée sans paramètres, la fonction retourne une icone par défaut
		 * @param {int} number numéro du centre de formation
		 * @param {String} type 'autocar' ou 'point' pour un point coloré ou éclairci
		 * @return {string} url
		 */
		Maps.prototype.icon = function(number, type) {
			if(number === undefined || number == -1) {
				return 'https://chart.googleapis.com/chart?chst=d_map_pin_letter&chld=O|C0C0C0|C0C0C0';
				//return './inc/icon/marker.png';
			} else {
				var color = this.colors[number % this.colors.length];
				if(type == 'autocar') {
					return 'https://chart.googleapis.com/chart?chst=d_map_pin_letter&chld='+number+'|'+color[0]+'|'+color[2]+'';
				} else {
					return 'https://chart.googleapis.com/chart?chst=d_map_pin_letter&chld='+number+'|'+color[1]+'|'+color[2]+'';
				}
			}
		};
				
		/**
		 * Initialiser la carte
		 */
		Maps.prototype.initialize = function() {
			var id = this.getId();
			document.write('<div id="map-wrap'+id+'" class="map-wrap"></div>');
			document.getElementById('map-wrap'+id).innerHTML = '<div id="map-canvas'+id+'" class="map-canvas">Chargement de la carte...</div><div id="map-infos'+id+'"></div>';
			this.global_maps_bounds = new google.maps.LatLngBounds();
			var opts = {
				center: new google.maps.LatLng(36.4, -118.8),
				zoom: 6,
				minZoom: 4,
				maxZoom: 17
			};
			this.global_maps_map = new google.maps.Map(document.getElementById('map-canvas'+id), opts);
			this.global_maps_geocoder = new google.maps.Geocoder();
		};
		
		/**
		 * Fonction pour effacer les markeurs sur la carte
		 */
		Maps.prototype.clear_places = function() {
			for(var i = 0 ; i < this.global_maps_markersArray.length ; i++) {
				this.global_maps_markersArray[i].setMap(null);
			}
			this.global_maps_markersArray = [];
		};
		
		/**
		 * Charger les lieux
		 */
		Maps.prototype.load_places = function() {

			this.clear_places();
			
			for(var i = 0 ; i < this.global_data.places.length ; i++) {
				var place = this.global_data.places[i];

				var location = new google.maps.LatLng(place.latitude,place.longitude);
				this.set_place(location, i);
			}
			
			if(this.options.itineraires) {
				this.way();
			}
		};
		
		/**
		 * Placer un lieu
		 */
		Maps.prototype.set_place = function(location, i) {

			var icon = this.icon();
			
			this.global_maps_bounds.extend(location);
			this.global_maps_map.fitBounds(this.global_maps_bounds);
			var marker = new google.maps.Marker({
				map: this.global_maps_map,
				position: location
				//animation: google.maps.Animation.DROP,
				//icon: icon
			});
			//marker.setTitle(global_data.places[i].nom);
			this.global_maps_markersArray.push(marker);
			
			var contentMarker = '<div style="width:	200px; height: 40px;">'+this.global_data.places[i].nom+'</div>';

			var infoWindow = new google.maps.InfoWindow({
				content  : contentMarker,
				position : location,
				animation: google.maps.Animation.DROP,
				disableAutoPan: true
			});
			
			var $this = this;
			
			google.maps.event.addListener(marker, 'click', function() {
				if($this.options.infosbulles) {
					infoWindow.open($this.global_maps_map, marker);
				}
			});
			
			// actions éventuelles au survol
			google.maps.event.addListener(marker, 'mouseover', function() {
				$this.global_delay_check = marker;
				
				$this.delay(marker, function() {
					if($this.options.infosbulles) {
						//infoWindow.open($this.global_maps_map, marker);
					}
				});
				
			});
			
			google.maps.event.addListener(marker, 'mouseout', function() {
				$this.global_delay_check = null;
			
				if($this.options.infosbulles) {
					//infoWindow.close();
				}
			});
			
		};
		
		/**
		 * Calculer la distance 
		 */
		Maps.prototype.way = function(){
			
			var size = this.global_maps_markersArray.length;
			var maxwaypoints = 8; // fixé par Google
			
			var nbitineraires = Math.ceil((size - 1) / (maxwaypoints + 1));
			this.global_maps_directions_nbrequests = nbitineraires;
			this.global_maps_directions_nbresponses = 0;
			
			var directionsService = new google.maps.DirectionsService();
			
			this.global_maps_directions = [];
			for(var i = 0 ; i < nbitineraires ; i++) {
				this.global_maps_directions[i] = new google.maps.DirectionsRenderer({
					map: this.global_maps_map,
					hideRouteList: true,
					preserveViewport: true, // pour le zoom auto
					markerOptions: { visible: false }
				});
				
				var from = i * (maxwaypoints + 1);
				var to = from+ (maxwaypoints + 1);
				if(to >= size) {
					to = size - 1;
				}
				
				var origin = this.global_maps_markersArray[from].getPosition();
				var destination = this.global_maps_markersArray[to].getPosition();
				
				var waypoints = [];
				for(var wp = from + 1 ; wp < to ; wp++) {
					waypoints.push({location: this.global_maps_markersArray[wp].getPosition()});
				}
				
				if(origin && destination){
					var request = {
						origin      : origin,
						destination : destination,
						waypoints	: waypoints,
						optimizeWaypoints : true,
						travelMode  : google.maps.DirectionsTravelMode.DRIVING
					}
					this.serviceRequest(directionsService, request, i);		
				}
			
			}
		};
		
		Maps.prototype.serviceRequest = function(service, request, index) {
			var $this = this;
			service.route(request, function(response, status){
				console.log(response);
				if(status == google.maps.DirectionsStatus.OK){
					$this.global_maps_directions[index].setDirections(response);
					for(var l = 0 ; l < response.routes[0].legs.length ; l++) {
						$this.global_data.total_distance += response.routes[0].legs[l].distance.value;
					}
					$this.global_maps_directions_nbresponses++;
					if($this.global_maps_directions_nbrequests == $this.global_maps_directions_nbresponses) {
						//document.getElementById('map-infos'+$this.getId()).innerHTML = 'Distance totale : ' + Math.ceil($this.global_data.total_distance / 1000) + ' km';
					}
				}
			});
		};
		
		Maps.prototype.refresh = function() {
			this.load_places();
		};
		
		Maps.prototype.newPlace = function(pNom, pLongitude, pLatitude) {
			return { latitude:pLatitude, longitude:pLongitude, nom:pNom };
		};
		Maps.prototype.addPlace = function(pNom, pLongitude, pLatitude) {
			this.global_data.places.push(this.newPlace(pNom, pLongitude, pLatitude));
		};

		/**
		 * Delai pour les actions de survol ou de clic
		 */
		Maps.prototype.delay = function(check, callback) {
			var $this = this;
			window.setTimeout(function() {
				if($this.global_delay_check == check) {
					callback();
				}
			}, this.options.delai_survol);
		};
	
		Maps.initialized = true;
	}
	
	this.id = Maps.prototype.id++;
	this.initialize();
};