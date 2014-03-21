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

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author Junshik Jeon(service@opennaru.com, nameislocus@gmail.com)
 *
 */
public class SpringCacheExample {

	public SpringCacheExample() {
		
	}
	
	public void test() {
		ApplicationContext context =
			    new ClassPathXmlApplicationContext(new String[] {"spring-context.xml"});		

		TestRepository repo = context.getBean(TestRepository.class);
		repo.saveMember(new Member(1, "test1"));
		repo.saveMember(new Member(2, "test2"));
		System.out.println( repo.getMemberWithId(1) );
		System.out.println( repo.getMemberWithId(1) );
		System.out.println( repo.getMemberWithId(1) );
		
		System.out.println( repo.getMemberWithId(2) );
		System.out.println( repo.getMemberWithId(2) );
		System.out.println( repo.getMemberWithId(2) );
	}
	
	public static void main(String[] args) {
		SpringCacheExample example = new SpringCacheExample();
		example.test();
	}
}
