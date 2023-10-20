package ru.job4j.ood.isp;

public interface Worker {

    /* например маляр не может это всё - нарушение isp */
    void dig();  /* копать */
    void paint();  /* красить */
    void cleanUp();  /* убираться */
    void plaster();  /* штукатурить */
    void layingTiles();  /* класть плитку */
    void move();  /* переместить */
    void weld();  /* приварить (металл) */
}
