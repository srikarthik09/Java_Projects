/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sudokusolverwebapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author jtexpo
 */
@Entity
public class SQLSudokuBoard implements Serializable{
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String author;
    private String name;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    // Before you think that I have gone mad, I did not type this by hand
    // I used python to execute the following command...
    // for q in range(9):
    //   for t in range(9):
    //      print(f'private int t{q}{t};')
    //   print()
    // I was not goign to waist an hour changing a didget 81 times
    
    private int t00;
    private int t01;
    private int t02;
    private int t03;
    private int t04;
    private int t05;
    private int t06;
    private int t07;
    private int t08;
    
    private int t10;
    private int t11;
    private int t12;
    private int t13;
    private int t14;
    private int t15;
    private int t16;
    private int t17;
    private int t18;
    
    private int t20;
    private int t21;
    private int t22;
    private int t23;
    private int t24;
    private int t25;
    private int t26;
    private int t27;
    private int t28;

    private int t30;
    private int t31;
    private int t32;
    private int t33;
    private int t34;
    private int t35;
    private int t36;
    private int t37;
    private int t38;

    private int t40;
    private int t41;
    private int t42;
    private int t43;
    private int t44;
    private int t45;
    private int t46;
    private int t47;
    private int t48;

    private int t50;
    private int t51;
    private int t52;
    private int t53;
    private int t54;
    private int t55;
    private int t56;
    private int t57;
    private int t58;

    private int t60;
    private int t61;
    private int t62;
    private int t63;
    private int t64;
    private int t65;
    private int t66;
    private int t67;
    private int t68;

    private int t70;
    private int t71;
    private int t72;
    private int t73;
    private int t74;
    private int t75;
    private int t76;
    private int t77;
    private int t78;

    private int t80;
    private int t81;
    private int t82;
    private int t83;
    private int t84;
    private int t85;
    private int t86;
    private int t87;
    private int t88;
    
    public void ConvertArrayToIndiVals(List<List<List<Integer>>> board){
        // Once More I swear I didn't go crazy, I used Python to write this code. 
        // SQL can't store Nested Arrays, or at least I don't know how to make it
        // Store nested arrays, so how I am going to still allow for data to be stored
        // is manually flattening the array 
        // Python Code...
        // for q in range(9):
        //    for t in range(9):
        //        print(f'this.t{q}{t} = board.get({q}).get({t}).get(0);')
        //    print()
        this.t00 = board.get(0).get(0).get(0);
        this.t01 = board.get(0).get(1).get(0);
        this.t02 = board.get(0).get(2).get(0);
        this.t03 = board.get(0).get(3).get(0);
        this.t04 = board.get(0).get(4).get(0);
        this.t05 = board.get(0).get(5).get(0);
        this.t06 = board.get(0).get(6).get(0);
        this.t07 = board.get(0).get(7).get(0);
        this.t08 = board.get(0).get(8).get(0);

        this.t10 = board.get(1).get(0).get(0);
        this.t11 = board.get(1).get(1).get(0);
        this.t12 = board.get(1).get(2).get(0);
        this.t13 = board.get(1).get(3).get(0);
        this.t14 = board.get(1).get(4).get(0);
        this.t15 = board.get(1).get(5).get(0);
        this.t16 = board.get(1).get(6).get(0);
        this.t17 = board.get(1).get(7).get(0);
        this.t18 = board.get(1).get(8).get(0);

        this.t20 = board.get(2).get(0).get(0);
        this.t21 = board.get(2).get(1).get(0);
        this.t22 = board.get(2).get(2).get(0);
        this.t23 = board.get(2).get(3).get(0);
        this.t24 = board.get(2).get(4).get(0);
        this.t25 = board.get(2).get(5).get(0);
        this.t26 = board.get(2).get(6).get(0);
        this.t27 = board.get(2).get(7).get(0);
        this.t28 = board.get(2).get(8).get(0);

        this.t30 = board.get(3).get(0).get(0);
        this.t31 = board.get(3).get(1).get(0);
        this.t32 = board.get(3).get(2).get(0);
        this.t33 = board.get(3).get(3).get(0);
        this.t34 = board.get(3).get(4).get(0);
        this.t35 = board.get(3).get(5).get(0);
        this.t36 = board.get(3).get(6).get(0);
        this.t37 = board.get(3).get(7).get(0);
        this.t38 = board.get(3).get(8).get(0);

        this.t40 = board.get(4).get(0).get(0);
        this.t41 = board.get(4).get(1).get(0);
        this.t42 = board.get(4).get(2).get(0);
        this.t43 = board.get(4).get(3).get(0);
        this.t44 = board.get(4).get(4).get(0);
        this.t45 = board.get(4).get(5).get(0);
        this.t46 = board.get(4).get(6).get(0);
        this.t47 = board.get(4).get(7).get(0);
        this.t48 = board.get(4).get(8).get(0);

        this.t50 = board.get(5).get(0).get(0);
        this.t51 = board.get(5).get(1).get(0);
        this.t52 = board.get(5).get(2).get(0);
        this.t53 = board.get(5).get(3).get(0);
        this.t54 = board.get(5).get(4).get(0);
        this.t55 = board.get(5).get(5).get(0);
        this.t56 = board.get(5).get(6).get(0);
        this.t57 = board.get(5).get(7).get(0);
        this.t58 = board.get(5).get(8).get(0);

        this.t60 = board.get(6).get(0).get(0);
        this.t61 = board.get(6).get(1).get(0);
        this.t62 = board.get(6).get(2).get(0);
        this.t63 = board.get(6).get(3).get(0);
        this.t64 = board.get(6).get(4).get(0);
        this.t65 = board.get(6).get(5).get(0);
        this.t66 = board.get(6).get(6).get(0);
        this.t67 = board.get(6).get(7).get(0);
        this.t68 = board.get(6).get(8).get(0);

        this.t70 = board.get(7).get(0).get(0);
        this.t71 = board.get(7).get(1).get(0);
        this.t72 = board.get(7).get(2).get(0);
        this.t73 = board.get(7).get(3).get(0);
        this.t74 = board.get(7).get(4).get(0);
        this.t75 = board.get(7).get(5).get(0);
        this.t76 = board.get(7).get(6).get(0);
        this.t77 = board.get(7).get(7).get(0);
        this.t78 = board.get(7).get(8).get(0);

        this.t80 = board.get(8).get(0).get(0);
        this.t81 = board.get(8).get(1).get(0);
        this.t82 = board.get(8).get(2).get(0);
        this.t83 = board.get(8).get(3).get(0);
        this.t84 = board.get(8).get(4).get(0);
        this.t85 = board.get(8).get(5).get(0);
        this.t86 = board.get(8).get(6).get(0);
        this.t87 = board.get(8).get(7).get(0);
        this.t88 = board.get(8).get(8).get(0);
    }
    
    public List<List<List<Integer>>> IndiValsToArray(){
        // Same deal... more python
        List<List<List<Integer>>> board = new ArrayList<List<List<Integer>>>(){
            {
                add(new ArrayList<List<Integer>>(){{
                    add(new ArrayList<Integer>(){{add(t00);}});
                    add(new ArrayList<Integer>(){{add(t01);}});
                    add(new ArrayList<Integer>(){{add(t02);}});
                    add(new ArrayList<Integer>(){{add(t03);}});
                    add(new ArrayList<Integer>(){{add(t04);}});
                    add(new ArrayList<Integer>(){{add(t05);}});
                    add(new ArrayList<Integer>(){{add(t06);}});
                    add(new ArrayList<Integer>(){{add(t07);}});
                    add(new ArrayList<Integer>(){{add(t08);}});
                }});
                add(new ArrayList<List<Integer>>(){{
                    add(new ArrayList<Integer>(){{add(t10);}});
                    add(new ArrayList<Integer>(){{add(t11);}});
                    add(new ArrayList<Integer>(){{add(t12);}});
                    add(new ArrayList<Integer>(){{add(t13);}});
                    add(new ArrayList<Integer>(){{add(t14);}});
                    add(new ArrayList<Integer>(){{add(t15);}});
                    add(new ArrayList<Integer>(){{add(t16);}});
                    add(new ArrayList<Integer>(){{add(t17);}});
                    add(new ArrayList<Integer>(){{add(t18);}});
                }});
                add(new ArrayList<List<Integer>>(){{
                    add(new ArrayList<Integer>(){{add(t20);}});
                    add(new ArrayList<Integer>(){{add(t21);}});
                    add(new ArrayList<Integer>(){{add(t22);}});
                    add(new ArrayList<Integer>(){{add(t23);}});
                    add(new ArrayList<Integer>(){{add(t24);}});
                    add(new ArrayList<Integer>(){{add(t25);}});
                    add(new ArrayList<Integer>(){{add(t26);}});
                    add(new ArrayList<Integer>(){{add(t27);}});
                    add(new ArrayList<Integer>(){{add(t28);}});
                }});
                add(new ArrayList<List<Integer>>(){{
                    add(new ArrayList<Integer>(){{add(t30);}});
                    add(new ArrayList<Integer>(){{add(t31);}});
                    add(new ArrayList<Integer>(){{add(t32);}});
                    add(new ArrayList<Integer>(){{add(t33);}});
                    add(new ArrayList<Integer>(){{add(t34);}});
                    add(new ArrayList<Integer>(){{add(t35);}});
                    add(new ArrayList<Integer>(){{add(t36);}});
                    add(new ArrayList<Integer>(){{add(t37);}});
                    add(new ArrayList<Integer>(){{add(t38);}});
                }});
                add(new ArrayList<List<Integer>>(){{
                    add(new ArrayList<Integer>(){{add(t40);}});
                    add(new ArrayList<Integer>(){{add(t41);}});
                    add(new ArrayList<Integer>(){{add(t42);}});
                    add(new ArrayList<Integer>(){{add(t43);}});
                    add(new ArrayList<Integer>(){{add(t44);}});
                    add(new ArrayList<Integer>(){{add(t45);}});
                    add(new ArrayList<Integer>(){{add(t46);}});
                    add(new ArrayList<Integer>(){{add(t47);}});
                    add(new ArrayList<Integer>(){{add(t48);}});
                }});
                add(new ArrayList<List<Integer>>(){{
                    add(new ArrayList<Integer>(){{add(t50);}});
                    add(new ArrayList<Integer>(){{add(t51);}});
                    add(new ArrayList<Integer>(){{add(t52);}});
                    add(new ArrayList<Integer>(){{add(t53);}});
                    add(new ArrayList<Integer>(){{add(t54);}});
                    add(new ArrayList<Integer>(){{add(t55);}});
                    add(new ArrayList<Integer>(){{add(t56);}});
                    add(new ArrayList<Integer>(){{add(t57);}});
                    add(new ArrayList<Integer>(){{add(t58);}});
                }});
                add(new ArrayList<List<Integer>>(){{
                    add(new ArrayList<Integer>(){{add(t60);}});
                    add(new ArrayList<Integer>(){{add(t61);}});
                    add(new ArrayList<Integer>(){{add(t62);}});
                    add(new ArrayList<Integer>(){{add(t63);}});
                    add(new ArrayList<Integer>(){{add(t64);}});
                    add(new ArrayList<Integer>(){{add(t65);}});
                    add(new ArrayList<Integer>(){{add(t66);}});
                    add(new ArrayList<Integer>(){{add(t67);}});
                    add(new ArrayList<Integer>(){{add(t68);}});
                }});
                add(new ArrayList<List<Integer>>(){{
                    add(new ArrayList<Integer>(){{add(t70);}});
                    add(new ArrayList<Integer>(){{add(t71);}});
                    add(new ArrayList<Integer>(){{add(t72);}});
                    add(new ArrayList<Integer>(){{add(t73);}});
                    add(new ArrayList<Integer>(){{add(t74);}});
                    add(new ArrayList<Integer>(){{add(t75);}});
                    add(new ArrayList<Integer>(){{add(t76);}});
                    add(new ArrayList<Integer>(){{add(t77);}});
                    add(new ArrayList<Integer>(){{add(t78);}});
                }});
                add(new ArrayList<List<Integer>>(){{
                    add(new ArrayList<Integer>(){{add(t80);}});
                    add(new ArrayList<Integer>(){{add(t81);}});
                    add(new ArrayList<Integer>(){{add(t82);}});
                    add(new ArrayList<Integer>(){{add(t83);}});
                    add(new ArrayList<Integer>(){{add(t84);}});
                    add(new ArrayList<Integer>(){{add(t85);}});
                    add(new ArrayList<Integer>(){{add(t86);}});
                    add(new ArrayList<Integer>(){{add(t87);}});
                    add(new ArrayList<Integer>(){{add(t88);}});
                }});
            }
        }; 
        return board;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getT00() {
        return t00;
    }

    public void setT00(int t00) {
        this.t00 = t00;
    }

    public int getT01() {
        return t01;
    }

    public void setT01(int t01) {
        this.t01 = t01;
    }

    public int getT02() {
        return t02;
    }

    public void setT02(int t02) {
        this.t02 = t02;
    }

    public int getT03() {
        return t03;
    }

    public void setT03(int t03) {
        this.t03 = t03;
    }

    public int getT04() {
        return t04;
    }

    public void setT04(int t04) {
        this.t04 = t04;
    }

    public int getT05() {
        return t05;
    }

    public void setT05(int t05) {
        this.t05 = t05;
    }

    public int getT06() {
        return t06;
    }

    public void setT06(int t06) {
        this.t06 = t06;
    }

    public int getT07() {
        return t07;
    }

    public void setT07(int t07) {
        this.t07 = t07;
    }

    public int getT08() {
        return t08;
    }

    public void setT08(int t08) {
        this.t08 = t08;
    }

    public int getT10() {
        return t10;
    }

    public void setT10(int t10) {
        this.t10 = t10;
    }

    public int getT11() {
        return t11;
    }

    public void setT11(int t11) {
        this.t11 = t11;
    }

    public int getT12() {
        return t12;
    }

    public void setT12(int t12) {
        this.t12 = t12;
    }

    public int getT13() {
        return t13;
    }

    public void setT13(int t13) {
        this.t13 = t13;
    }

    public int getT14() {
        return t14;
    }

    public void setT14(int t14) {
        this.t14 = t14;
    }

    public int getT15() {
        return t15;
    }

    public void setT15(int t15) {
        this.t15 = t15;
    }

    public int getT16() {
        return t16;
    }

    public void setT16(int t16) {
        this.t16 = t16;
    }

    public int getT17() {
        return t17;
    }

    public void setT17(int t17) {
        this.t17 = t17;
    }

    public int getT18() {
        return t18;
    }

    public void setT18(int t18) {
        this.t18 = t18;
    }

    public int getT20() {
        return t20;
    }

    public void setT20(int t20) {
        this.t20 = t20;
    }

    public int getT21() {
        return t21;
    }

    public void setT21(int t21) {
        this.t21 = t21;
    }

    public int getT22() {
        return t22;
    }

    public void setT22(int t22) {
        this.t22 = t22;
    }

    public int getT23() {
        return t23;
    }

    public void setT23(int t23) {
        this.t23 = t23;
    }

    public int getT24() {
        return t24;
    }

    public void setT24(int t24) {
        this.t24 = t24;
    }

    public int getT25() {
        return t25;
    }

    public void setT25(int t25) {
        this.t25 = t25;
    }

    public int getT26() {
        return t26;
    }

    public void setT26(int t26) {
        this.t26 = t26;
    }

    public int getT27() {
        return t27;
    }

    public void setT27(int t27) {
        this.t27 = t27;
    }

    public int getT28() {
        return t28;
    }

    public void setT28(int t28) {
        this.t28 = t28;
    }

    public int getT30() {
        return t30;
    }

    public void setT30(int t30) {
        this.t30 = t30;
    }

    public int getT31() {
        return t31;
    }

    public void setT31(int t31) {
        this.t31 = t31;
    }

    public int getT32() {
        return t32;
    }

    public void setT32(int t32) {
        this.t32 = t32;
    }

    public int getT33() {
        return t33;
    }

    public void setT33(int t33) {
        this.t33 = t33;
    }

    public int getT34() {
        return t34;
    }

    public void setT34(int t34) {
        this.t34 = t34;
    }

    public int getT35() {
        return t35;
    }

    public void setT35(int t35) {
        this.t35 = t35;
    }

    public int getT36() {
        return t36;
    }

    public void setT36(int t36) {
        this.t36 = t36;
    }

    public int getT37() {
        return t37;
    }

    public void setT37(int t37) {
        this.t37 = t37;
    }

    public int getT38() {
        return t38;
    }

    public void setT38(int t38) {
        this.t38 = t38;
    }

    public int getT40() {
        return t40;
    }

    public void setT40(int t40) {
        this.t40 = t40;
    }

    public int getT41() {
        return t41;
    }

    public void setT41(int t41) {
        this.t41 = t41;
    }

    public int getT42() {
        return t42;
    }

    public void setT42(int t42) {
        this.t42 = t42;
    }

    public int getT43() {
        return t43;
    }

    public void setT43(int t43) {
        this.t43 = t43;
    }

    public int getT44() {
        return t44;
    }

    public void setT44(int t44) {
        this.t44 = t44;
    }

    public int getT45() {
        return t45;
    }

    public void setT45(int t45) {
        this.t45 = t45;
    }

    public int getT46() {
        return t46;
    }

    public void setT46(int t46) {
        this.t46 = t46;
    }

    public int getT47() {
        return t47;
    }

    public void setT47(int t47) {
        this.t47 = t47;
    }

    public int getT48() {
        return t48;
    }

    public void setT48(int t48) {
        this.t48 = t48;
    }

    public int getT50() {
        return t50;
    }

    public void setT50(int t50) {
        this.t50 = t50;
    }

    public int getT51() {
        return t51;
    }

    public void setT51(int t51) {
        this.t51 = t51;
    }

    public int getT52() {
        return t52;
    }

    public void setT52(int t52) {
        this.t52 = t52;
    }

    public int getT53() {
        return t53;
    }

    public void setT53(int t53) {
        this.t53 = t53;
    }

    public int getT54() {
        return t54;
    }

    public void setT54(int t54) {
        this.t54 = t54;
    }

    public int getT55() {
        return t55;
    }

    public void setT55(int t55) {
        this.t55 = t55;
    }

    public int getT56() {
        return t56;
    }

    public void setT56(int t56) {
        this.t56 = t56;
    }

    public int getT57() {
        return t57;
    }

    public void setT57(int t57) {
        this.t57 = t57;
    }

    public int getT58() {
        return t58;
    }

    public void setT58(int t58) {
        this.t58 = t58;
    }

    public int getT60() {
        return t60;
    }

    public void setT60(int t60) {
        this.t60 = t60;
    }

    public int getT61() {
        return t61;
    }

    public void setT61(int t61) {
        this.t61 = t61;
    }

    public int getT62() {
        return t62;
    }

    public void setT62(int t62) {
        this.t62 = t62;
    }

    public int getT63() {
        return t63;
    }

    public void setT63(int t63) {
        this.t63 = t63;
    }

    public int getT64() {
        return t64;
    }

    public void setT64(int t64) {
        this.t64 = t64;
    }

    public int getT65() {
        return t65;
    }

    public void setT65(int t65) {
        this.t65 = t65;
    }

    public int getT66() {
        return t66;
    }

    public void setT66(int t66) {
        this.t66 = t66;
    }

    public int getT67() {
        return t67;
    }

    public void setT67(int t67) {
        this.t67 = t67;
    }

    public int getT68() {
        return t68;
    }

    public void setT68(int t68) {
        this.t68 = t68;
    }

    public int getT70() {
        return t70;
    }

    public void setT70(int t70) {
        this.t70 = t70;
    }

    public int getT71() {
        return t71;
    }

    public void setT71(int t71) {
        this.t71 = t71;
    }

    public int getT72() {
        return t72;
    }

    public void setT72(int t72) {
        this.t72 = t72;
    }

    public int getT73() {
        return t73;
    }

    public void setT73(int t73) {
        this.t73 = t73;
    }

    public int getT74() {
        return t74;
    }

    public void setT74(int t74) {
        this.t74 = t74;
    }

    public int getT75() {
        return t75;
    }

    public void setT75(int t75) {
        this.t75 = t75;
    }

    public int getT76() {
        return t76;
    }

    public void setT76(int t76) {
        this.t76 = t76;
    }

    public int getT77() {
        return t77;
    }

    public void setT77(int t77) {
        this.t77 = t77;
    }

    public int getT78() {
        return t78;
    }

    public void setT78(int t78) {
        this.t78 = t78;
    }

    public int getT80() {
        return t80;
    }

    public void setT80(int t80) {
        this.t80 = t80;
    }

    public int getT81() {
        return t81;
    }

    public void setT81(int t81) {
        this.t81 = t81;
    }

    public int getT82() {
        return t82;
    }

    public void setT82(int t82) {
        this.t82 = t82;
    }

    public int getT83() {
        return t83;
    }

    public void setT83(int t83) {
        this.t83 = t83;
    }

    public int getT84() {
        return t84;
    }

    public void setT84(int t84) {
        this.t84 = t84;
    }

    public int getT85() {
        return t85;
    }

    public void setT85(int t85) {
        this.t85 = t85;
    }

    public int getT86() {
        return t86;
    }

    public void setT86(int t86) {
        this.t86 = t86;
    }

    public int getT87() {
        return t87;
    }

    public void setT87(int t87) {
        this.t87 = t87;
    }

    public int getT88() {
        return t88;
    }

    public void setT88(int t88) {
        this.t88 = t88;
    }
    
}
