angular.module('appModule')
	.component('todo', {
		templateUrl : 'app/todo.component.html',
		controller : function($scope, todoService) {
			var vm = this;
			
			vm.todos = [];
			vm.showTodos= function() {
				todoService.index()
					.then(function(response) {
						vm.todos = response.data;
						
					})
			}
			
			vm.showTodos();
			
		},
		controllerAs : 'vm'
	})