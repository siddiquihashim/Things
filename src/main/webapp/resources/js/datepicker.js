
$(function() {
		$("#datepicker1").datepicker({
		      showButtonPanel: true,
		      changeMonth: true,
		      changeYear: true,
		      dateFormat: "d M, y"
	    });
		
		$("#datepicker2").datepicker({
		      showButtonPanel: true,
		      numberOfMonths: 3,
		      changeMonth: true,
		      changeYear: true,
		      dateFormat: "d M, y"
	    });
	});
