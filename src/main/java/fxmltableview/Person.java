/*
 * Copyright (c) 2012, 2014 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  - Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  - Neither the name of Oracle nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package fxmltableview;

import javafx.beans.property.SimpleStringProperty;

public class Person {

    private final SimpleStringProperty username = new SimpleStringProperty("");
    private final SimpleStringProperty name = new SimpleStringProperty("");
    private final SimpleStringProperty email = new SimpleStringProperty("");
    private final SimpleStringProperty password = new SimpleStringProperty("");
    private final SimpleStringProperty role = new SimpleStringProperty("");

    

    public Person() {
        this("", "", "", "", "");
    }

    public Person(String username, String name, String email, String password, String role) {
        setUsername(username);
        setName(name);
        setEmail(email);
        setPassword(password);
        setRole(role);
    }

    public String getUsername() {
        return username.get();
    }

    public void setUsername(String fName) {
    	username.set(fName);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String fName) {
    	name.set(fName);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String fName) {
        email.set(fName);
    }
    public String getPassword() {
        return password.get();
    }

    public void setPassword(String fName) {
    	password.set(fName);
    }
    public String getRole() {
        return role.get();
    }

    public void setRole(String fName) {
    	role.set(fName);
    }
    
}