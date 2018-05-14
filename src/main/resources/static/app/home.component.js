angular.module('appModule').component(
		'home', 
		{
			templateUrl : 'app/home.component.html',
			controller : function($location) {
				var vm = this;
				
			},
			
			controllerAs : 'vm'
		})