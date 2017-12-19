$(document).ready(function(){
	
	var contextRoot = "/" + window.location.pathname.split('/')[1];
	
	acceptOrder = function(deliveryOrderId) {
				
		$.ajax({
			type : 'post',
			url : contextRoot + '/acceptOrderDelivery/' + deliveryOrderId,
			dataType : "json",
			contentType : 'application/json',
			success : function(response) {
				alert("Order accepted");
				
				location.reload();
				
			},
			error : function(errorObject) {
				alert("There is an error with this order");
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
	
});
	