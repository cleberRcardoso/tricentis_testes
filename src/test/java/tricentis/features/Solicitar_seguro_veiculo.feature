#language: pt
#encoding: utf-8
Funcionalidade: Solicitar seguro veicular tricentis

	@safe_request
	Cenario: Preencher o formulário Enter Vehicle Data
		Dado que acessei o Tricentis no chorme
		E preencho o formulario "Enter Vehicle Data" e pressione next
		E preencho o formulario "Enter Insurant Data" e pressione next
		E preencho o formulario "Enter Product Data" e pressione next
		E preencho o formulario "Select Price Option" e pressione next
		Quando preencho o fomrulario Send Quote e pressione Send
		Entao valido que o email foi enviado com sucesso

