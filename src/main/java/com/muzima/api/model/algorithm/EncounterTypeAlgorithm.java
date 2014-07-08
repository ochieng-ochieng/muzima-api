/**
 * Copyright 2012 Muzima Team
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
 */
package com.muzima.api.model.algorithm;

import com.muzima.api.model.EncounterType;
import com.muzima.search.api.model.object.Searchable;
import com.muzima.util.JsonUtils;
import net.minidev.json.JSONObject;

import java.io.IOException;

/**
 * TODO: Write brief description about the class here.
 */
public class EncounterTypeAlgorithm extends BaseOpenmrsAlgorithm {

    public static final String ENCOUNTER_TYPE_STANDARD_REPRESENTATION = "(uuid,name)";

    /**
     * Implementation of this method will define how the object will be serialized from the String representation.
     *
     * @param serialized the string representation
     * @return the concrete object
     */
    @Override
    public Searchable deserialize(final String serialized) throws IOException {
        EncounterType encounterType = new EncounterType();
        encounterType.setUuid(JsonUtils.readAsString(serialized, "$['uuid']"));
        encounterType.setName(JsonUtils.readAsString(serialized, "$['name']"));
        return encounterType;
    }

    /**
     * Implementation of this method will define how the object will be de-serialized into the String representation.
     *
     * @param object the object
     * @return the string representation
     */
    @Override
    public String serialize(final Searchable object) throws IOException {
        EncounterType encounterType = (EncounterType) object;
        JSONObject jsonObject = new JSONObject();
        JsonUtils.writeAsString(jsonObject, "uuid", encounterType.getUuid());
        JsonUtils.writeAsString(jsonObject, "name", encounterType.getName());
        return jsonObject.toJSONString();
    }
}
