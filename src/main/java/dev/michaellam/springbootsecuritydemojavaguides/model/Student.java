/*
 * @Author: Michael Lam 
 * @Date: 2023-06-29 15:03:03
 * @LastEditTime: 2023-06-29 15:48:02
 * @Description: 
 */
package dev.michaellam.springbootsecuritydemojavaguides.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Student {
  private long id;
  private String firstName;
  private String lastName;

}
