Vue.http.options.emulateJSON = true;
	new Vue({
	  el: '#my_data',
	  data: {
		 details: {
		  about: "",
		  preferences: "",
		  location: "",
		  _csrf: ""	  
		 },
		 uname: "",
		 prefs: []
	  },
	  mounted: function() {

	     
	     this.uname = $("#uname").val();
	     this.details['_csrf'] = $("#csrf").val();
	    
	     this.getElements();
	  },
	  methods : {
		  updateUser : function() {
			for (i = 0; i < this.prefs.length; i++)
				this.details['preferences'] += this.prefs[i] + " ";
	    	var data = this.details;
	    	
	    	var url = '/rest/updateUser/'+this.uname;
	          this.$http.post(url, data).then(response => {
	          	location.href.reload;
	      }, response => {
	        // error callback
	        alert(response);
	      });
	    },
	  	getElements : function() {
	  		url = '/rest/getUserDetails/' + this.uname;
	  		this.$http.get(url).then(response => {
	  			if (response.body['about'] != null && response.body['about'] != "udndefined")
	  			this.details['about'] = response.body['about'];
	  			if (response.body['preferences'] != null && response.body['preferences'] != "udndefined") {
                    for (i = 0; i < response.body['preferences'].length; i++)
                    	this.prefs.push(response.body['preferences'][i]);
				}

	  			if (response.body['location'] != null && response.body['location'] != "udndefined")
	  			this.details['location'] = response.body['location'];

	  		}, response => {

	  		});
	  	},
	  	theClass : function(index){
	  		return "event-"+this.events[index]['important'];
	  	},
	  	addPreference : function() {
	  		console.log($("#pref").val());

	  		this.prefs.push($("#pref").val());
	  		$("#pref").val("");
	  	},
	  	removePreference : function (inx) {
			this.prefs.splice(inx, 1);
        }
	  }
	})
