app.controller('UserController',function($scope,$rootScope,$location,UserService){
	console.log('entering the user controller')
	$scope.users;
	$scope.user={id:'',username:'',password:'',email:'',role:'',isOnline:'',enabled:''};
	$scope.message;
	function fetchAllUsers()
	{
		console.log('entering fetchall users  in controller')
		UserService.fetchAllUsers()
		.then(
				function(d)
				{
					console.log('entered to d')
					$scope.users=d;
				},
				function(error)
				{
					console.log(error);
				}
				)
	}
	fetchAllUsers();
	$scope.submit=function(){
		console.log('Entering - submit function in usercontroller')
		
		console.log('Emtering controller login')
		UserService.authenticate($scope.user)
		.then(function(response){
			console.log('entering success login')
				$scope.user=response.data;
				$rootScope.currentUser=$scope.user;
				$location.path("/home");
		},
		function(response){//invalid user name and password - failure 
			 console.log('invalid username and password')
			  $scope.message="Invalid Username and Password!!";
			  $location.path("/login");
		})
	}
	
	$scope.registerUser=function()
	{
		console.log('entering function save in user controller')
	
		UserService.registerUser($scope.user)
		.then(
		  function(response)
		  {
			  //console.log(d.status) 
			  console.log("registration success" + response.status)
				$location.path("/home");
			  //fetchAllPersons();
			  //redirect
			 // $location.path('/listOfPerson')
		  },
		  function(response)
		  {
			  //console.log(d.status)
			  console.log("registration failed" + response.status)
			console.log(response.data)
			$scope.errorMessage="Registration failed...." + response.data.message
			$location.path("/register")
		  });
	}
	
	$rootScope.logout=function(){
		console.log('logout function')
		delete $rootScope.currentUser;
		
		UserService.logout()
		.then(function(response){
			console.log("logged out successfully..");
			$scope.message="Logged out Successfully";
			$location.path('/login')
		},
		function(response){
			console.log(response.status);
		})
		
	}
	/*$scope.registerUser=function(){
		console.log('entering registerUser')
		UserService.registerUser($scope.user)
		.then(function(response){ //success 
			console.log("registration success" + response.status)
			$location.path("/home");
		},function(response){//failure
			console.log("registration failed" + response.status)
			console.log(response.data)
			$scope.errorMessage="Registration failed...." + response.data.message
			$location.path("/register")
		})
	}*/
})