/**
 * @license
 * Copyright 2017 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

export class NewDataservice {

  private keng__id: string;
  private keng__dataPath: string;
  private keng__kType: string;
  private tko__description: string;

  /**
   * Constructor
   */
  constructor() {
    this.keng__kType = "Dataservice";
  }

  /**
   * @returns {string} the dataservice name (can be null)
   */
  public getId(): string {
    return this.keng__id;
  }

  /**
   * @returns {string} the dataservice description (can be null)
   */
  public getDescription(): string {
    return this.tko__description;
  }

  /**
   * @param {string} name the dataservice name
   */
  public setId( name: string ): void {
    this.keng__id = name;
    this.keng__dataPath = "/tko:komodo/tko:workspace/dsbUser/" + name;
  }

  /**
   * @param {string} description the dataservice description (optional)
   */
  public setDescription( description?: string ): void {
    this.tko__description = description ? description : null;
  }
}
