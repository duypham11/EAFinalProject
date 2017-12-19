$(document).ready(function(){
	// to get the profile
	var getProfile = function (){
	   	var contextRoot = "/" + window.location.pathname.split( '/' )[1];
		$.ajax({
			type : 'GET',
			url : contextRoot + '/storeProfile',
			dataType : 'json',
			contentType : 'application/json',
			success: function(respond){
				console.log(respond);
				$("#id").val(respond.id);
				$("#storeName").val(respond.name);
				$("#firstName").val(respond.firstName);
				$("#lastName").val(respond.lastName);
				$("#address").val(respond.addressAsString);
				$("#email").val(respond.email);
				$("#note").val(respond.note);
			},
			error : function(error) {
				console.debug(error);
				console.log(error.responseJSON.errorType);
				if (error.responseJSON.errorType == "ValidationError") {
					var errors = error.responseJSON.errors;
					$.each(errors, function(i, error){
						$("#modalBody").append("<div class='alert alert-success alert-dismissable'>" +error+"</div>");
					});
				} else {
					alert(error.responseJSON.errors(0));
				}
			}
		}).then(function(){
			if(respond !== null){
				$("#myModal").modal();
			}
		});
	};
	
	// to cancel the request
	cancelRiderRequest = function(id){
		console.log("cancel rider request " + id);
	   	var contextRoot = "/" + window.location.pathname.split( '/' )[1];
		$.ajax({
			type : 'GET',
			url : contextRoot + '/cancelRiderRequest/'+id,
			dataType : 'json',
			contentType : 'application/json',
			success: function(respond){
				console.log(respond);
				alert(respond.message);
				if(respond.status == 'SUCCESS'){
					window.location.reload();
				}
				
				
			},
			error : function(error) {
				console.debug(error);
				alert(error.message);
			}
		});
	};
	
	$("#btnProfile").click(getProfile);
	
});
	