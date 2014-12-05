/**
 * 
 */
$(document).ready(function() {
    $(function() {
        $("#cityFrom").autocomplete({
        	minLength : 3,
            source: function(request, response) {
                $.ajax({
                    url: "/tf2la/getCities",
                    type: "POST",
                    data: { term: request.term },

                    dataType: "json",
               
                    success: function(data) 
                    {
                    	
                    	response($.map(data, function(v,i){
                    	    return {
                    	                label: v.cityName +" woj. "+ v.voivodeshipName + " pow. "+v.districtName,
                    	                value: v

                    	               };
                    	               
                    	}));
                    	
                    	
                    }
               });              
            },
        
            select: function (event, ui) {
                var v = ui.item.value;
                $("#cityFromHidden").val(v.cityID);

                // update what is displayed in the textbox
                this.value = v.cityName +" woj. "+ v.voivodeshipName + " pow. "+v.districtName;
                return false;
            }
        });
        
        
        
    });
    $("#cityTo").autocomplete({
    	minLength : 3,
        source: function(request, response) {
            $.ajax({
                url: "/tf2la/getCities",
                type: "POST",
                data: { term: request.term },

                dataType: "json",

                success: function(data) {
                	response($.map(data, function(v,i){
                		
                		
                	    return {
                	                label: v.cityName +" woj. "+ v.voivodeshipName + " pow. "+v.districtName,
                	                value: v
                	               };
                	}));
                }
           });              
        },
        select: function (event, ui) {
            var v = ui.item.value;
            $("#cityToHidden").val(v.cityID);

            // update what is displayed in the textbox
            this.value = v.cityName +" woj. "+ v.voivodeshipName + " pow. "+v.districtName;
            return false;
        }
    });

});