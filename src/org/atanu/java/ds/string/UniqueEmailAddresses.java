package org.atanu.java.ds.string;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/unique-email-addresses/
//LeetCode 929
public class UniqueEmailAddresses {

    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmail = new HashSet<>();

        for(String email : emails){
            StringBuilder sb = new StringBuilder();
            for(char ch : email.toCharArray()){
                if(ch == '@' || ch == '+'){
                    break;
                }

                if(ch == '.'){
                    continue;
                }

                sb.append(ch);
            }
            String cleanEmail = sb.toString() + email.substring(email.indexOf('@'));
            uniqueEmail.add(cleanEmail);
        }

        return uniqueEmail.size();
    }

    //No Use of split or Index Of
    public int numUniqueEmailsV2(String[] emails) {
        Set<String> uniqueEmail = new HashSet<>();

        for(String email : emails){
            StringBuilder emailSb = new StringBuilder();
            // iterate over each character in email
            for(char ch : email.toCharArray()){
                // stop adding characters to localName
                if(ch == '@' || ch == '+'){
                    break;
                }
                // add this character if not '.'
                if(ch == '.'){
                    continue;
                }

                emailSb.append(ch);
            }

            // compute domain name (substring from end to '@')
            StringBuilder domainSb = new StringBuilder();
            for(int i = email.length() -1 ; i >= 0; i--){
                char ch  = email.charAt(i);
                domainSb.append(ch);
                if(ch == '@'){
                    break;
                }
            }

            domainSb.reverse();

            emailSb.append(domainSb);

            uniqueEmail.add(emailSb.toString());
        }

        return uniqueEmail.size();
    }
}
