/*******************************************************************************
 * Copyright [2016] [Quirino Brizi (quirino.brizi@gmail.com)]
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
angular.module('core.utils').factory('Utils', [ function() {
  return {
    invoke : function(fcn, args) {
      return this[fcn](args);
    },
    formatBytes : function(bytes, decimals) {
      if (!bytes) {
        return bytes;
      }
      if (bytes == 0) {
        return '0';
      }
      var k = 1000; // or 1024 for binary
      var dm = decimals + 1 || 2;
      var sizes = [ 'Bytes', 'KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB' ];
      var i = Math.floor(Math.log(bytes) / Math.log(k));
      return parseFloat((bytes / Math.pow(k, i)).toFixed(dm)) + ' ' + sizes[i];
    },
    formatCpuPercentage : function(value) {
      if (!value) {
        return value;
      }
      return value.toFixed(2) + ' ' + '%' ;
    },
    formatAsNumber : function(value) {
      if (!value) {
        return value;
      }
      return value + ' ' + '#' ;
    },
    noop: function(value) {
      return value;
    }
  }
} ]);