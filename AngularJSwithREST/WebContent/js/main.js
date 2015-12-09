var myapp = angular.module('myapp', ['ngRoute','ngCsv','ui.bootstrap', 'ngResource','ngDialog','ngAnimate']);

myapp.config(function($routeProvider) {
	$routeProvider
	.when('/home', {
		templateUrl: 'product.html',
		controller: 'productController'
	})
	.when('/productDetails', {
		templateUrl: 'productDetails.html',
		controller: 'productController'
	})
	.otherwise({
		redirectTo: '/home'
	});
});

/*myapp.config(function(IdleProvider, KeepaliveProvider) {
	IdleProvider.idle(900); 
	IdleProvider.timeout(60);
	//KeepaliveProvider.interval(600); # heartbeat every 10 min
	//KeepaliveProvider.http('/api/heartbeat'); # URL that makes sure session is alive
}); */

//myapp.run(function($rootScope) {
//	console.log("Session started");
//	$rootScope.$on('IdleStart', function() { console.log("Idle time started");/* Display modal warning or sth */ });
//	$rootScope.$on('IdleTimeout', function() { /* Logout user */ });
//}); 

myapp.controller('productController', function($scope, $http, $rootScope,ngDialog,$location) {
	$http.get('./rest/product/findalljson').success(function(response) {
		$scope.result = response.product;
		
		$scope.totalItems = response.product.length;
		$scope.currentPage = 1;
		$scope.numPerPage = 5;
		$scope.changeNumpages();
		
		console.log($scope.result);
	});

	$scope.message="";
	$scope.sortType     = 'id';
	$scope.sortReverse  = false;

	$scope.changeNumpages = function(){
		$scope.numpages= Math.ceil($scope.totalItems/$scope.numPerPage);
	};
	
	$scope.listAllBeacons = function(){
		$http.get('./rest/beacon').success(function(response) {
			$scope.beacons = response.beacon;
			
			console.log($scope.beacons);
		});
	}
	$scope.openContactForm = function() {
		
		$scope.listAllBeacons();
		
		$rootScope.id = '';
		$rootScope.name = '';
		$rootScope.price = '';
		$rootScope.quantity = '';
		$rootScope.beaconid='';
		ngDialog.openConfirm({template: 'addProduct.html',
			controller: 'productController',
			scope: $scope //Pass the scope object if you need to access in the template
		}).then(
				function(value) {

				},
				function(value) {
					//Cancel or do nothing
				}
		);
	};
	
	$scope.searchProduct = function(){
		
		var dataObj = {
			id: $scope.searchID,
			name:$scope.searchName,
			price:$scope.searchPrice,
			quantity:$scope.searchQuantity
		
		};
		
		console.log("Data Obj is "  + dataObj);
		
		$http.post('./rest/product/find', dataObj).success(function(response) {
			$scope.result = response.product;
			$scope.totalItems = response.product.length;
			
			$scope.currentPage = 1;
			$scope.numPerPage = 5;
			$scope.changeNumpages();
			
			console.log($scope);
		});
	};
	$scope.openDetailsForm=function(id){
		
		$scope.selectEdit(id);
		ngDialog.openConfirm({template: 'details.html',
			controller: 'productController',
			scope: $scope //Pass the scope object if you need to access in the template
		}).then(
				function(value) {

				},
				function(value) {
					//Cancel or do nothing
				}
		);
	};
	$scope.editProduct = function() {
		ngDialog.openConfirm({template: 'productDetails.html',
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
	$scope.paginate = function(value) {
		var begin, end, index;
		begin = ($scope.currentPage - 1) * $scope.numPerPage;
		end = begin + $scope.numPerPage;
		index = $scope.result.indexOf(value);		    
		return (begin <= index && index < end);
	};
	$scope.del = function(id) {
		if (confirm("Are you sure to delete ? ")) {
		var index = getSelectedIndex(id);
		var res = $http.delete('./rest/product/'+id);
		res.success(function(response) {
			//alert("Deleted successfully");
			$scope.result.splice(index, 1);
			$scope.id = '';
			$scope.name = '';
			$scope.price = '';
			$scope.quantity = '';
		});
		res.error(function(response) {
			alert("Failed to delete");
		})

		}
	};

	$scope.selectEdit = function(id) {
		var index = getSelectedIndex(id);
		var product = $scope.result[index];

		$rootScope.id = product.id;
		$rootScope.name = product.name;
		$rootScope.price = product.price;
		$rootScope.quantity = product.quantity;
	};
	
	$scope.add = function() {
		
		var dataObj = {
				beaconid :$scope.beaconid,
				id : $scope.id,
				name : $scope.name,
				price : $scope.price,
				quantity : $scope.quantity
		};

		var res = $http.post('./rest/product', dataObj);
		res.success(function(data, status, headers, config) {
			$scope.result.push({
				id : $scope.id,
				name : $scope.name,
				price : $scope.price,
				quantity : $scope.quantity
			});
			$scope.successmessage="Product added succesfully";
			console.log(config);
		});
		res.error(function(data, status, headers, config) {
			$scope.errormessage="Failed to add product";
			console.log(config);
		});

	};

	$scope.edit = function() {
		var index = getSelectedIndex($scope.id);
		var product = $scope.result[index];
		var dataObj = {
				id : $scope.id,
				name : $scope.name,
				price : $scope.price,
				quantity : $scope.quantity
		};
		var res = $http.put('./rest/product', dataObj);

		res.success(function(data, status, headers, config) {
			$scope.result[index].name = $scope.name;
			$scope.result[index].price = $scope.price;
			$scope.result[index].quantity = $scope.quantity;

		});

		res.error(function(data, status, headers, config) {
			alert("failure message: " + headers);
		});
	};
	function getSelectedIndex(id) {
		for (var i = 0; i < $scope.result.length; i++) {
			if ($scope.result[i].id == id)
				return i;
		}
		return -1;
	}

	$scope.confirm =  function () {
		try{
			$scope.successmessage='';
			$scope.errormessage='';
			$scope.add();

		}catch(err){
			scope.errormessage=err;
		}
	};

	$scope.closethis=function(){
		$scope.successmessage='';
		$scope.errormessage='';
		$location.path('/');
	}
	$scope.getHeader = function () {return ["Id", "Name","Price","Quantity"]};



});


//Custom directive

myapp.directive("helloworld", function() {
	return{
		restrict: "E",
		template: "<div>This is a custom div</div>"
	}
});

