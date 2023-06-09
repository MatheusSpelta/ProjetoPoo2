/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import dominio.ProdutoVenda;
import dominio.Cliente;
import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Matheus
 */
@Entity
@Table(name = "venda")

public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venda")
    private Integer idVenda;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column(name = "data_venda")
    private LocalDate dataVenda;

    @Column(name = "valor_total")
    private Double valorTotal;

    @Column(name = "entrega")
    private boolean entrega;

    @Column(name = "valor_frete")
    private Double valorFrete;

    @Column(name = "desconto")
    private Double valorDesconto;

    @Column(name = "total_venda")
    private Double totalVenda;

    @Column(name = "cancelada")
    private boolean cancelada;

    @OneToMany(mappedBy = "venda", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProdutoVenda> produtos = new ArrayList<>();

    @OneToOne
    @MapsId
    @JoinColumn(name = "idFP")
    private FormaPagamento fp;

    //Setter, Getter and Constructors
    public Venda() {
    }

    public Venda(Integer idVenda, Cliente cliente, Double valorTotal, FormaPagamento formaPagamento, boolean entrega, Double valorFrete, Double valorDesconto, String funcionario) {
        this.idVenda = idVenda;
        this.cliente = cliente;
        this.valorTotal = valorTotal;
        this.fp = formaPagamento;
        this.entrega = entrega;
        this.valorFrete = valorFrete;
        this.valorDesconto = valorDesconto;
    }

    public Venda(Cliente cliente, Double valorTotal, boolean entrega, Double valorFrete, Double valorDesconto, Double totalVenda, FormaPagamento fp) {
        this.cliente = cliente;
        this.dataVenda = LocalDate.now();
        this.valorTotal = valorTotal;
        this.entrega = entrega;
        this.valorFrete = valorFrete;
        this.valorDesconto = valorDesconto;
        this.totalVenda = totalVenda;
        this.fp = fp;
        this.cancelada = false;
    }

    public Integer getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public boolean isEntrega() {
        return entrega;
    }

    public void setEntrega(boolean entrega) {
        this.entrega = entrega;
    }

    public Double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(Double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public boolean isCancelada() {
        return cancelada;
    }

    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }

    public List<ProdutoVenda> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoVenda> produtos) {
        this.produtos = produtos;
    }

    public Double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(Double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public FormaPagamento getFp() {
        return fp;
    }

    public void setFp(FormaPagamento fp) {
        this.fp = fp;
    }

    public Double getTotalVenda() {
        return totalVenda;
    }

    public void setTotalVenda(Double totalVenda) {
        this.totalVenda = totalVenda;
    }

    public Object[] toArray() throws ParseException {
        return new Object[]{this, this.cliente.getNome(), this.getDataVenda(), this.getTotalVenda()};
        //return new Object[]{this, this.cliente.getIdCliente(), this.cliente.getNome(), this.cliente.getCpf(), this.cliente.getCnpj(), this.cliente.getCelular(), this.cliente.getEndereco().getRua(), this.cliente.getEndereco().getNumero(), this.cliente.getEndereco().getBairro(), this.cliente.getEndereco().getCidade(), this.getProdutos(), this.getValorTotal(), this.getValorDesconto(), this.entrega, this.getValorFrete(), this.getFp(), this.getTotalVenda()};
    }

    @Override
    public String toString() {
        return "" + idVenda;
    }

}
