package icu.zeeman.exps.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zeeman Zhang
 */
@NoArgsConstructor(onConstructor_ = { @Deprecated })
@AllArgsConstructor
@Data
public class Customer {
    private int id;
    private String username;
    private String jobs;
    private String phone;
}
