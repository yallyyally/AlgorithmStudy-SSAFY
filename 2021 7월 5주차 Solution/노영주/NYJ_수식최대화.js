'use strict';
function solution(expression) {
    const order =[['*','+','-'],['*','-','+'],['+','*','-'],['+','-','*'],['-','*','+'],['-','+','*']];
    
    let result=[];
    
    for(let op of order){
        const exp = expression.split(/(\D)/);
        for(let cal of op){
            while(exp.includes(cal)){
                const index = exp.indexOf(cal);
                //splice(start,deleteCount,insert);
                //피연산자 범위 0~999. 처음수에는 cal이 포함될 일이 없다.
                exp.splice(index-1,3,eval(exp.slice(index-1,index+2).join('')));
            }
        }
        result.push(Math.abs(exp[0]));
    }
    
    return Math.max(...result);
}