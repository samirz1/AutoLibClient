/**
 * Rediriger vers une url
 * @param href
 */
function loc(href) {
	document.location.href = href;
}

/**
 * Rediriger vers une url si le message est confirmé
 * @param msg
 * @param href
 */
function loc_conf(msg, href) {
	if(confirm(msg)) {
		loc(href);
	}
}

$(document).ready(function(){
	$('.historyback').bind('click', function(event) {
		history.back();
	});
	
});