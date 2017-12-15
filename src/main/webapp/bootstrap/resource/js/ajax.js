// pathname is contextRoot/path/path/ so we want to get [1] 
// that is where contextRoot is
// [0] has "" as a result of split 

$(function() {
	
	var contextRoot = "/" + window.location.pathname.split('/')[1];
//	alert(contextRoot);
	var data ={};
	update= function(id,kind){
		url =contextRoot+ "/disable";
		data = {
				"email":id,
				"id":""
		};
		if(kind=="1"){
			url =contextRoot+ "/enable";
		}
        
    	$.ajax({
    		type : 'post',
    		url : url,
    		dataType : "json", // Accept header
    		data:JSON.stringify(data),
    		contentType : 'application/json', // Sends - Content-type
    		success : function(response) {
    			alert(response.desc);
    			//Code here..
    			window.location.reload();
    		},
    		error : function(errorObject,textStatus,httpstatus) {
    			
    			alert(textStatus);
    			alert(httpstatus);
    		}
    	});
	}
	
	$(".btn btn-primary").click(function() {
        url =contextRoot+ $(this).val();
    	$.ajax({
    		type : 'post',
    		url : url,
    		dataType : "json", // Accept header
    		contentType : 'application/json', // Sends - Content-type
    		success : function(response) {
    			alert(response.desc);
    			//Code here..
    		},
    		error : function(errorObject,textStatus,httpstatus) {
    			
    			alert(textStatus);
    			alert(httpstatus);
    		}
    	});
        
    });
	

	
	
	
	
//	
});
