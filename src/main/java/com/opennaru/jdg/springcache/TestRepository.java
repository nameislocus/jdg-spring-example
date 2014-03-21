/*
 * Opennaru, Inc. http://www.opennaru.com/
 *  
 * Copyright 2014 Opennaru, Inc. and/or its affiliates.
 * All rights reserved by Opennaru, Inc.
 * 
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package com.opennaru.jdg.springcache;

import java.util.HashMap;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Junshik Jeon(service@opennaru.com, nameislocus@gmail.com)
 *
 */
@Repository
public class TestRepository {
	HashMap<Integer, Member> hash = new HashMap<Integer, Member>();
	
	@Cacheable("members")
	public Member getMemberWithId(int id) {
		System.out.println(">>> getMemberWithId=" + id);
		Member member = hash.get(id);
		System.out.println(">>> member=" + member);
		return member;
	}

	@CacheEvict(value = "members", allEntries = true)
	public void saveMember(final Member member) {
		hash.put(member.getMemberId(), member);
		System.out.println("<<< saveMember=" +member);
	}
}
