/**
 * Copyright [2016-17] [Quirino Brizi (quirino.brizi@gmail.com)]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package eu.codesketch.adam.rest.domain.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * V.O. abstract an image stored on repository
 * 
 * @author quirino.brizi
 *
 */
public class Image {

    private final Long created;
    private final String id;
    private final String parentId;
    private final List<String> repoTags;
    private final Long size;
    private final Long virtualSize;

    public Image(Long created, String id, String parentId, Long size, Long virtualSize, String[] repoTags) {
        this.created = created;
        this.id = id;
        this.parentId = parentId;
        this.size = size;
        this.virtualSize = virtualSize;
        this.repoTags = Arrays.asList(repoTags);
    }

    public Long getCreated() {
        return created;
    }

    public String getId() {
        return id;
    }

    public String getParentId() {
        return parentId;
    }

    public List<String> getRepoTags() {
        return Collections.unmodifiableList(repoTags);
    }

    public Long getSize() {
        return size;
    }

    public Long getVirtualSize() {
        return virtualSize;
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!getClass().equals(obj.getClass())) {
            return false;
        }
        Image other = (Image) obj;
        return new EqualsBuilder().append(this.id, other.id).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.id).toHashCode();
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this);
        builder.append("created", created).append("id", id).append("parentId", parentId).append("repoTags", repoTags)
                .append("size", size).append("virtualSize", virtualSize);
        return builder.toString();
    }

}
