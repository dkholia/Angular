var myapp = angular.module('myapp', ['ngRoute','ngCsv','ui.bootstrap', 'ngResource','ngDialog','ngAnimate']);

myapp.config(function($routeProvider) {
	$routeProvider
	.when('/home', {
		templateUrl: 'product.html',
		controller: 'productController'
	})
	.when('/userRegister', {
		templateUrl: 'registeruser.html',
		controller: 'userController'
	})
	.otherwise({
		redirectTo: '/home'
	});
});

myapp.controller('userController', function($scope, $http, $rootScope,ngDialog,$location) {
	$scope.registerUser = function() {
		ngDialog.openConfirm({template: 'registeruser.html',
			scope: $scope //Pass the scope object if you need to access in the template
		}).then(
				function(value) {
					//save the contact form
				},
				function(value) {
					//Cancel or do nothing
				}
		);
	};
});