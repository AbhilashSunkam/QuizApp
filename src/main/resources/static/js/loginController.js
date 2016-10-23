angular.module("app", []).controller("home", function($http) {
			var self = this;
			$http.get("/user").success(function(data) {
				self.user = data.userAuthentication.details.name;
				console.log(self.user);
				self.authenticated = true;
			}).error(function() {
				self.user = "N/A";
				self.authenticated = false;
			});
		});

		angular.module("app", []).controller("home",
				function($http, $location) {
					var self = this;
					self.logout = function() {
						$http.post('/logout', {}).success(function() {
							self.authenticated = false;
							$location.url("/");
							console.log($location.url("/"));
						}).error(function(data) {
							console.log("Logout failed")
							self.authenticated = false;
						});
					};
				});