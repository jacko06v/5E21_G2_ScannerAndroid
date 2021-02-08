Mosconi, Aouioua, Guiducci

Percentuale di lavoro svolto fin ora:
Mosconi: 34%
Guiducci: 33%
Aouioua: 33%


########APPLICAZIONE PER IL NOSTRO SERVER

l’applicazione funziona e trasmette i dati con il server php in questo momento

-schiacciando il tasto elimina si apre un menu dove sono presenti due radio button, bisogna selezionare il radio button corrispondente alla tabella dove vogliamo diminuire di 1 la quantità del prodotto che andremo a scansionare (come se il prodotto fosse venduto)

    errori da considerare non valutati: 
-	radiobutton lasciati vuoti
-	il prodotto scansionato non è salvato nel db
-	la quantità è già a 0 (andrebbe poi in negativo la quantità) 

 le ultime due cose sono da aggiustare nel file server.php (in teoria sono solo degli if, quello sulla quantità si fa anche velocemente dato che la quantità viene già presa dal db)
la prima invece nell’app con qualche try catch o if

-  schiacciano il tasto inserisci si aprirà un menu con 2 radiobutton principali (aggiorna/inserisci nuovo) 3 radio button secondari (categorie della tabella) e 3 textbox (nome-costo-tempo necessario per il servizio)

-	quando si aggiorna un prodotto già esistente basta indicare la categoria (ovvero la tabella) e scansionare il codice. se si inseriscono dati dentro le textbox non avviene nessun errore perché non vengono considerate dal codice
-	quando si aggiunge un prodotto nuovo bisogna indicare la categoria e obbligatoriamente completare la textbox nome e la textbox prezzo.
 la textbox tempo necessario è obbligatoria solo nel caso in cui il prodotto da aggiungere sia un servizio
-	dopodichè si scansiona il codice che contiene l’id del prodotto 

 errori da considerare non valutati: 
-	id scansionato già utilizzato per un altro prodotto
-	qualche textbox lasciata vuota
-	radiobutton lasciati vuoti

il primo errore da considerare nel file server.php, gli altri due nell’app con qualche try catch o if (se guardate nel codice in alcuni if-else ho già scritto i messaggi di errore, per capire come scriverli, sono completamente diversi da c#)

cose da sistemare

-	per ora è possibile selezionare tutti i radiobutton contemporaneamente. 
 bisogna che sia possibile schiacciare solo un radiobutton nella pagina elimina e un radiobutton principale e uno solo  secondario nella pagina inserisci.




#######APPLICAZIONE SERVER GIANLUCA 

Anche questa applicazione funziona completamente, con il server di gianluca è stata semplificata molto perché gestisce praticamente tutto lui lato server
c’è sempre il menu principale con “inserisci/elimina”, schiacciando un bottone si apre sempre un secondo menù, ma entrambi hanno solo 2 radiobutton con scritto “pezzo/accessorio” da scegliere.

il QR code deve contenere in questo ordine ID - Breve descrizione/nome - numero pezzo (non ho ben capito cosa sia il numero pezzo, ma lui lo vuole a 3 cifre) il tutto separato da |

Esempio: PZ34|volante figo audi|560

tramite l’app viene fatto lo split del contenuto del qr code e id - descrizione - numero pezzo vengono messi in un array, poi il tutto viene mandato sempre tramite l’url come nell’applicazione precedente

Errori da sistemare: 

un try catch quando stampa le variabili dell’array, perché se per qualche motivo il qr code non ha il separatore o mancano dei dati, l’app cerca comunque di stampare le caselle dell’array che sarebbero dovute essere occupate dai dati, quindi se sono vuote può verificarsi un errore.

COSE DA FARE IN ENTRAMBI I CASI DI PROGETTO
-	miglioramento grafica
-	aggiunta di commenti vari all'intero codice
-	redazione di una documentazione adeguata all'uso dell'applicazione





