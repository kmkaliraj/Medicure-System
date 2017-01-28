$(document).ready(function() {
	setTimeout(function() {
		// Accordion
		$('#menu5 > li > a.expanded + ul').slideToggle('medium');
		$('#menu5 > li > a').click(function() {
			$('#menu5 > li > a.expanded').not(this).toggleClass('expanded').toggleClass('collapsed').parent().find('> ul').slideToggle('medium');
			$(this).toggleClass('expanded').toggleClass('collapsed').parent().find('> ul').slideToggle('medium');
		});
	}, 250);
});

function showmenu(elmnt)
{
document.getElementById(elmnt).style.visibility="visible";
}
function hidemenu(elmnt)
{
document.getElementById(elmnt).style.visibility="hidden";
}