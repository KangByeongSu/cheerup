$(document).ready(function() {

	$("#txtSearch").keyup(function(event){
		console.log("hi");
	   /*
		if(event.keyCode == 13){
			var txtSearch = $("#txtSearch").val();
	    	$.ajax({
				url : "./"+txtSearch,
				method : "GET",
				success : function(resData) {
					console.log(restData);
				},
				error : function() {
				}
			});
	    	
	    }*/
	});

})

