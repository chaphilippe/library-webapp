angular.module('library.app', [ 'library.services', 'library.controllers', 'library.filters', 'library.directives' ])

/**
 * Configure routes and controllers
 */
.config(function($routeProvider) {
  $routeProvider.when('/login', {
    controller : 'loginCtrl',
    templateUrl : 'partials/login.html'

  }).when('/students', {
    controller : 'studentListCtrl',
    templateUrl : 'partials/student-list.html',
    resolve : { checkLogin : 'checkLogin' }

  }).when('/students/new', {
    controller : 'studentDetailCtrl',
    templateUrl : 'partials/student-detail.html',
    resolve : { checkLogin : 'checkLogin' }

  }).when('/students/:studentId', {
    controller : 'studentDetailCtrl',
    templateUrl : 'partials/student-detail.html',
    resolve : { checkLogin : 'checkLogin' }

  }).when('/teachers', {
	    controller : 'teacherListCtrl',
	    templateUrl : 'partials/teacher-list.html',
	    resolve : { checkLogin : 'checkLogin' }
  }).when('/teachers/new', {
	    controller : 'teacherDetailCtrl',
	    templateUrl : 'partials/teacher-detail.html',
	    resolve : { checkLogin : 'checkLogin' }
  }).when('/teachers/:teacherId', {
	    controller : 'teacherDetailCtrl',
	    templateUrl : 'partials/teacher-detail.html',
	    resolve : { checkLogin : 'checkLogin' }
  }).when('/signup', {
	    controller : 'signUpCtrl',
	    templateUrl : 'partials/signup.html'
  }).when('/signup', {
		    controller : 'signUpCtrl',
		    templateUrl : 'partials/signup.html'
		      
  }).otherwise({
    redirectTo : '/login'
  });

})

/**
 * Configure HTTP interceptors
 */
.config(function($httpProvider) {
	
	/**
	 * Error interceptor, catch all for unhandled http errors
	 * displays global error dialog from index.html
	 */
    function errorInterceptor($q, $log) {
        function success(response) {
            return response;
        }
        function error(response) {
            if ($.inArray(response.status, [ 400, 420, 404, 415, 500 ])) {
                $('#system-error-dialog').modal().on('hidden.bs.modal', function() {
                    window.location = '#/students';
                });
            }
            return $q.reject(response);
        }
        return function(promise) {
            return promise.then(success, error);
        };
    }

    /**
     * Auth Interceptor, redirects to home screen when 403
     * returned from server
     */
    function authInterceptor($q, $log, $location) {
        function success(response) {
            return response;
        }
        function error(response) {
            if (response.status == 403) { // Forbidden
                $location.path('/students');
            }
            return $q.reject(response);
        }
        return function(promise) {
            return promise.then(success, error);
        };
    }

    $httpProvider.responseInterceptors.push(errorInterceptor);
    $httpProvider.responseInterceptors.push(authInterceptor);

});


/**
 *  initialise other modules 
 */
angular.module('library.services', [ 'ngResource' ]);
angular.module('library.directives', []);
angular.module('library.controllers', [ 'ngCookies', 'i18n' ]);
angular.module('library.filters', [ 'i18n' ]);



