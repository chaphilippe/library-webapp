angular.module('library.services')

.factory('studentService', function($resource) {
  return $resource('api/students/:studentId', {}, {});
});


