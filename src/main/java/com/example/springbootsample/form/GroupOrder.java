package com.example.springbootsample.form;

import javax.validation.GroupSequence;

//Bean ValidationのGroup sequenceは単項目チェック、相関チェックの順序指定で使うのは止めた方が良さそう
@GroupSequence({ValidGroup1.class,ValidGroup2.class})
public interface GroupOrder {
    
}
