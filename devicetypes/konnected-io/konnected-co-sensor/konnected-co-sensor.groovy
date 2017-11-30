/**
 *  Konnected Smoke Sensor
 *
 *  Copyright 2017 konnected.io
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */
metadata {
  definition (name: "Konnected CO Sensor", namespace: "konnected-io", author: "konnected.io") {
    capability "Carbon Monoxide Detector"
    capability "Sensor"
  }
  tiles {
    multiAttributeTile(name:"main", type: "generic", width: 6, height: 4, canChangeIcon: true) {
      tileAttribute ("device.carbonMonoxide", key: "PRIMARY_CONTROL") {
        attributeState ("clear",    label: "Clear", icon:"st.alarm.smoke.clear", backgroundColor:"#ffffff")
        attributeState ("detected", label: "CO detected!", icon:"st.alarm.carbon-monoxide.carbon-monoxide", backgroundColor:"#e86d13")
      }
    }
    main "main"
    details "main"
  }
}

//Update state sent from parent app
def setStatus(state) { 
  switch(state) {
    case "0" :
      sendEvent(name: "carbonMonoxide", value: "clear")
      break
    case "1" :
      sendEvent(name: "carbonMonoxide", value: "detected")
      break
    default:
      sendEvent(name: "carbonMonoxide", value: "detected")
      break
  }
}