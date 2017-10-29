package ru.ovsyannikova.calculator.domain.task.model;

public class Task {
    private Long id;
    private String task;
    private String created;
    private Double result;
    private Integer additionsAmount;
    private Integer subtractionsAmount;
    private Integer multiplicationsAmount;
    private Integer divisionsAmount;
    private Integer powersAmount;
    private Integer leftParenthesisAmount;
    private Integer rightParenthesisAmount;

    public Task(String task, String created, Double result, Integer additionsAmount, Integer subtractionsAmount, Integer multiplicationsAmount, Integer divisionsAmount, Integer powersAmount, Integer leftParenthesisAmount, Integer rightParenthesisAmount) {
        this.task = task;
        this.created = created;
        this.result = result;
        this.additionsAmount = additionsAmount;
        this.subtractionsAmount = subtractionsAmount;
        this.multiplicationsAmount = multiplicationsAmount;
        this.divisionsAmount = divisionsAmount;
        this.powersAmount = powersAmount;
        this.leftParenthesisAmount = leftParenthesisAmount;
        this.rightParenthesisAmount = rightParenthesisAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public Integer getAdditionsAmount() {
        return additionsAmount;
    }

    public void setAdditionsAmount(Integer additionsAmount) {
        this.additionsAmount = additionsAmount;
    }

    public Integer getSubtractionsAmount() {
        return subtractionsAmount;
    }

    public void setSubtractionsAmount(Integer subtractionsAmount) {
        this.subtractionsAmount = subtractionsAmount;
    }

    public Integer getMultiplicationsAmount() {
        return multiplicationsAmount;
    }

    public void setMultiplicationsAmount(Integer multiplicationsAmount) {
        this.multiplicationsAmount = multiplicationsAmount;
    }

    public Integer getDivisionsAmount() {
        return divisionsAmount;
    }

    public void setDivisionsAmount(Integer divisionsAmount) {
        this.divisionsAmount = divisionsAmount;
    }

    public Integer getPowersAmount() {
        return powersAmount;
    }

    public void setPowersAmount(Integer powersAmount) {
        this.powersAmount = powersAmount;
    }

    public Integer getLeftParenthesisAmount() {
        return leftParenthesisAmount;
    }

    public void setLeftParenthesisAmount(Integer leftParenthesisAmount) {
        this.leftParenthesisAmount = leftParenthesisAmount;
    }

    public Integer getRightParenthesisAmount() {
        return rightParenthesisAmount;
    }

    public void setRightParenthesisAmount(Integer rightParenthesisAmount) {
        this.rightParenthesisAmount = rightParenthesisAmount;
    }
}
