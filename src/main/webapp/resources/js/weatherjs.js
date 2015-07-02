$(document).ready(function() {
	$('#slideshow').cycle({
	fx: 'fade',
	pager: '#smallnav', 
	pause:   1, 
	speed: 10000,
	timeout:  2900 
});		
	$('.nonUSmetric').hide();
	$('#zip').val('');
});

function togglerMetric()
{

	$('.nonUSmetric').toggle();
	$('.USmetric').toggle();
}