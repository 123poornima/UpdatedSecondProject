app.controller('JobController',function($scope,$location,JobService){
	console.log('entering the job controller')
	$scope.jobs;
	$scope.job={jobTitle:'',jobDescription:'',skillsRequired:'',salary:'',location:''}
	$scope.message;
	/*function getAllJobs()
	{
		console.log('entering get all job  in controller')
		JobService.getAllJobs()
		.then(
				function(d)
				{
					console.log('entered to d')
					$scope.jobs=d;
				},
				function(error)
				{
					console.log(error);
				}
				)
	}
	getAllJobs();*/
	function getAllJobs(){
		console.log('entering get All jobs')
		JobService.getAllJobs()
		.then(function(response){
			console.log('entering success job')
			console.log(response.status); //200
			$scope.jobs=response.data;  //List<Job>
			
		},function(response){
			console.log(response.status)
		})
	}
	getAllJobs();
	
	$scope.getJobDetail=function(jobId){
		JobService.getJobDetail(jobId)
	.then(function(response){
		$scope.jobDetail=response.data; // single Job object
		console.log(response.status)
		
	},function(response){
		console.log(response.status)
	})
	}	
	
	$scope.saveJob=function(){
		console.log('entering save job in job controller')
		JobService.saveJob($scope.job)
		.then(function(response){
			console.log('entered sucess job')
			console.log("job success" + response.status)
			console.log("successfully inserted job details");
			alert("Posted job successfully");
			$location.path('/home');
		},function(response){
			console.log('Entered failure job')
			console.log("failure " +response.status);
			console.log(response.data.message)
			$location.path('/postJob')
		})
	}
	
	
/*	function getAllJobs(){
		console.log('entering get All jobs')
		JobService.getAllJobs()
		.then(function(response){
			console.log(response.status); //200
			$scope.jobs=response.data;  //List<Job>
			
		},function(response){
			console.log(response.status)
		})
	}
	getAllJobs();*/
})