$(document).ready(function(){
	
	var contextRoot = "/" + window.location.pathname.split('/')[1];
	
	selectParcel = function(riderId, parcelDeliverId) {

		$.ajax({
			type : 'post',
			url : contextRoot + '/selectParcel/' + riderId + '/' + parcelDeliverId,
			dataType : "json",
			contentType : 'application/json',
			success : function(response) {
				alert("Parcel has been selected");
				
				location.reload();
				
			},
			error : function(errorObject) {
				alert("There is an error with this parcel");
			}
		});
	}

	completedParcel = function(parcelDeliverId) {
		
		$("#parcelDeliverNumber").html("" + parcelDeliverId);
		$("#myModal").modal();
		
	}
	
	confirmParcel = function() {
		
		$("#emptyError").hide();
		
		if ($("#parcelId").val() != "") {
			
			$("#emptyError").hide();
			
			var  parcelId = $("#parcelDeliverNumber").text();
			var parcelNumber = $("#parcelId").val();
			
			$.ajax({
				type : 'post',
				url : contextRoot + '/completeParcel/' + parcelId + '/' + parcelNumber,
				dataType : "json",
				contentType : 'application/json',
				success : function(response) {
					location.reload();
				},
				error : function(errorObject) {
					alert("The track number is not valid");
				}
			});
			
		} else {
			$("#emptyError").show();
		}

	}
	
	var getProfile = function (){
	   	var contextRoot = "/" + window.location.pathname.split( '/' )[1];
		$.ajax({
			type : 'GET',
			url : contextRoot + '/riderProfile',
			dataType : 'json',
			contentType : 'application/json',
			success: function(respond){
				console.log(respond);
				$("#id").val(respond.id);
				$("#firstName").val(respond.firstName);
				$("#lastName").val(respond.lastName);
				$("#address").val(respond.addressAsString);
				$("#email").val(respond.email);
				$("#rate").val(respond.rate);
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
				$("#myProfileModal").modal();
			}
		});
	};
	$("#btnRiderProfile").click(getProfile);

	
});
	