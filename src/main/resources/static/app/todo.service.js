angular.module('appModule')
	.factory('todoService', function($http) {
		var service = {};
		
		var BASE_URL = "/api/todo/"
		
		service.index = function() {
			return $http({
				method : "GET",
				url : BASE_URL + "todos",
				
			})
		}
		
		return service;
	})