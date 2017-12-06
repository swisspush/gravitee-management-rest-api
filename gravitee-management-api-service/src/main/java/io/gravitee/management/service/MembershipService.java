/**
 * Copyright (C) 2015 The Gravitee team (http://gravitee.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gravitee.management.service;

import io.gravitee.management.model.*;
import io.gravitee.repository.management.model.Membership;
import io.gravitee.repository.management.model.MembershipReferenceType;
import io.gravitee.repository.management.model.RoleScope;

import java.util.Map;
import java.util.Set;

/**
 * @author Nicolas GERAUD (nicolas.geraud at graviteesource.com)
 * @author GraviteeSource Team
 */
public interface MembershipService {

    MemberEntity getMember(MembershipReferenceType referenceType, String referenceId, String username, RoleScope roleScope);

    RoleEntity getRole(MembershipReferenceType referenceType, String referenceId, String username, RoleScope roleScope);

    Set<RoleEntity> getRoles(MembershipReferenceType referenceType, Set<String> referenceIds, String username, RoleScope roleScope);

    Set<MemberEntity> getMembers(MembershipReferenceType referenceType, String referenceId, RoleScope roleScope);

    Set<MemberEntity> getMembers(MembershipReferenceType referenceType, String referenceId, RoleScope roleScope, String roleName);

    MemberEntity addOrUpdateMember(MembershipReferenceType referenceType, String referenceId, String username, RoleScope roleScope, String roleName);

    void deleteMember(MembershipReferenceType referenceType, String referenceId, String username);

    void transferApiOwnership(String apiId, String username);

    void transferApplicationOwnership(String applicationId, String username);

    Map<String, char[]> getMemberPermissions(ApiEntity api, String username);

    Map<String, char[]> getMemberPermissions(ApplicationEntity application, String username);

    boolean removeRole(MembershipReferenceType referenceType, String referenceId, String username, RoleScope roleScope);
}
