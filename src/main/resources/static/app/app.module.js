angular.module('appModule', ['ngRoute']).config(
		function($routeProvider) {
			$routeProvider.when('/', {
				template : '<home></home>'
			}).when('/todos', {
				template : '<todo></todo>'
			})
			
		})