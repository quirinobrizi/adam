/*******************************************************************************
 * Copyright [2016] [Quirino Brizi (quirino.brizi@gmail.com)]
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
angular
  .module('swarm.containers')
  .component('swarmContainers', {
    templateUrl: 'js/swarm-containers/swarm-containers.template.html',
    controller: ['Swarm', '$routeParams',
      function SwarmDetailController(Swarm, $routeParams) {
        var self = this;

        self.swarmId = $routeParams.swarmId;
        self.containers = Swarm.containers({
          swarmId: self.swarmId
        });

        self.doInContainer = function(swarmId, containerId, action) {
          Swarm.doInContainer({
            swarmId: swarmId,
            containerId: containerId,
            action: action
          }).$promise.then(function(resp) {
            self.containers = resp;
          });
        };
        
        self.removeContainer = function(swarmId, containerId) {
          Swarm.removeContainer({
            swarmId: swarmId,
            containerId: containerId
          }).$promise.then(function(resp) {
            self.containers = resp;
          });
        }
      }
    ]
  });