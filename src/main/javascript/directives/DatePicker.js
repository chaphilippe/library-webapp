angular.module('library.directives')

/**
 * Datapicker directive
 */
.directive('datepicker', function($parse) {
  return {
    restrict : 'A',
    require : '?ngModel',
    link : function postLink(scope, elem, attrs, ngCtrl) {
      var params;

      var toDate = function(val) {
        var date = null;
        if (val != null && $.trim(val) != '' && val != 0) {
          elem.datepicker('setDate', new Date(val));
        } else {
          elem.val('');
        }
      };
      var modelAccessor = $parse(attrs.ngModel);
      var unregister = scope.$watch(modelAccessor, toDate);
      if (attrs.datepicker == 'true') {
        params = {
          dateFormat : 'dd/mm/yy',
          onSelect : function(dateText, inst) {
            scope.$apply(function(scope) {
              if (dateText != null && $.trim(dateText) != '') {
                modelAccessor.assign(scope, $.datepicker.parseDate('dd/mm/yy', dateText).getTime());
              } else {
                modelAccessor.assign(scope, null);
              }
            });
          }
        };
      } else {
        params = {
          dateFormat : 'dd/mm/yy',
          minDate : new Date(),
          onSelect : function(dateText, inst) {
            scope.$apply(function(scope) {
              if (dateText != null && $.trim(dateText) != '') {
                modelAccessor.assign(scope, $.datepicker.parseDate('dd/mm/yy', dateText).getTime());
              } else {
                modelAccessor.assign(scope, null);
              }
            });
          }
        };
      }
      elem.datepicker(params);
    }
  };
});
