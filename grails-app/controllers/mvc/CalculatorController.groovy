package mvc

import grails.validation.Validateable

class CalculatorController {

    def calc(CalculatorModel calculatorModel) {
        double result = (calculatorModel.en + calculatorModel.exam) / 2
        if (1 > calculatorModel.en || 6 < calculatorModel.en)
            calculatorModel.result = "'en' input is wrong"
        // Problematic en
        else if (1 > calculatorModel.exam || 6 < calculatorModel.exam) {
            // Problematic exam
            calculatorModel.result = "'exam' input is wrong"
        } else {
            calculatorModel.result = result
        }
        render view: "CalculatorOutput", model: [model: calculatorModel]
    }
}

//    def calc(double en, double exam) {
//        double result = (en + exam) / 2
//        render view: "CalculatorOutput", model: [result: result]  // Im "model" sind die Date  ; result als Variable
//    }
//}


class CalculatorModel implements Validateable{
    double en
    double exam
    String result

    static constraints = {
        en min:1d, max:6d, scale:1     // d steht für double    scale wie viele Zahlen nach dem Komma
        exam min:1d, max:6d, scale:1
        result nullable: true      // Obligatorisch für die Validierung
    }
}