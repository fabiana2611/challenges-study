package br.study.java.challenges;

import java.util.ArrayList;
import java.util.List;

public class Node {

    List<Node> children;
    Character valor;

    public void addChildren(Node node) {
        children.add(node);
    }

    public Node(Character valor) {
        this.valor = valor;
        children = new ArrayList<Node>();
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public Character getValor() {
        return valor;
    }

    public void setValor(Character valor) {
        this.valor = valor;
    }

}
