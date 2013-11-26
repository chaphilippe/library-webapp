angular.module('library.services')

.factory('teacherService', function($resource) {
  return $resource('api/teachers/:teacherId', {}, {});
});