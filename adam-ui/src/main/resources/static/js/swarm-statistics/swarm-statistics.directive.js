angular
  .module('swarm.statistics')
  .directive('swarmStatistics', function() {
    return {
      restrict: 'E',
      scope: {
        ngSwarm: '@'
      },
      templateUrl: 'js/swarm-statistics/swarm-statistics.template.html',
      controller: [
        '$scope', 'Swarm',
        function SwarmStatisticsController($scope, Swarm) {
          $scope.getSwarmStatistics = function(swarm) {
            $scope.swarmId = swarm;
            $scope.statistics = Swarm.getSwarmStatistics({
              swarmId: swarm
            });
          };

          $scope.formatBytes = function(bytes, decimals) {
            if(!bytes) {
              return bytes;
            }
            if (bytes == 0) {
              return '0';
            }
            var k = 1000; // or 1024 for binary
            var dm = decimals + 1 || 3;
            var sizes = ['Bytes', 'KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB'];
            var i = Math.floor(Math.log(bytes) / Math.log(k));
            return parseFloat((bytes / Math.pow(k, i)).toFixed(dm)); // + ' ' + sizes[i];
          };
        }
      ],
      link: function(scope, iElement, iAttrs) {
        scope.getSwarmStatistics(iAttrs.ngSwarm);
      }
    }
  });