# Eksamen 2019

## Oppgave 1

### 1a)

#### i

En kø er en datastruktur der verdier legges inn på et gitt sted, og tas ut fra et gitt sted. (Grunntilfellet kan sies å være legge inn bakerst, ta ut forrest).

#### ii

I en FIFO (First In Frst Out) kø legges verdier inn bakerst i køen, og tas ut forrest i køen. Dette gjør at de elementene som har ligget der lengst blir tatt ut først.

#### iii

I en LIFO (Last In First Out) er det alltid det siste elementet som ble lagt til som tas først ut.

#### iv

En stakk er en LIFO-kø.

#### v

Deque er en forkortelse av Double Ended Queue. Dette vil si at det er en kø der man kan legge inn i begge ender, og ta ut i begge ender.

#### vi

I en prioritets-kø har hvert element en prioritet, og det er denne som avgjør hvem som står for tur til å bli tatt ut.

### ib)

#### Del 1

Oppretter to Lister (Arrays) med karakterer (chars), ved kall på String-metoden toCharArray().

#### Del 2

Oppretter en ny Kø.
Iterer over den første Listen og legger til elemenetene i Køen.

Fjerner første element i Køen, og printer "Queue First: A".

Looper over de neste 4 elementene i køen, fjerner de fra køen, og printer de ut :
    "L, F, A, B"

Iterere over de  andre listen og legger elementene til i Køen.

Fjerner første elemenet i Køen, og printer "Queue Second: E"

Iterere til Køen er tom. For hvert element fjernes det fra køen, og printes :
"T, F, I, S, K"

#### Del 3

Gjør det samme med en Stakk.

#### Del 4

Gjør det samme med en PrioritetsKø.


## Oppgave 2

### 2a)

#### i

Partisjonering går ut på at man deler et array i to sub-arrays basert på om elementene er større eller mindre enn en gitt verdi. Denne verdien kalles Pivot (Skilleverdi).

#### ii

{B, C, A, F, K, L, T}

#### iii

Indeks 4.

### 2b)

#### i

Quicksort baserer seg på å rekursivt paritsjonere mindre og mindre sub-lister av den originale listen. Etter hver partisjonering vil skilleverdien være plassert på riktig set i listen.
Når da alle sublister er sortert vil også den originale listen være det.

#### ii

[B, C, K, A, F, L, T]

[B, C, F, A] K [L, T]

[B, A], C, F, K, L, T

A, B, C, F, K, L, T

### 2c)

#### i

Jeg ville brukt Rekusjon. Dette fordi det er ønskelig å kalle den samme funksjonen på alle sublister.

#### ii

O(n log(n)).

Dette er fordi antall ombyttinger i snitt vil være gitt ved log(n), og det vil være n elementer.

## Oppgave 3

### 3a)

En minimumsheap er et komplett minimumstre. Det vil si at:

- verdien i hver indre node er mindre eller like verdiene i barnenodene

- alle nivåer bortsett fra det siste er fyllt helt opp, og hvis det siste ikke er fullt er det fyllt fra venstre siden.

### 3b)

#### i 
For å legge inn et tall setter man først inn tallet i slutten av Heapen. Deretter "bobler" man den oppover. Det vil si at at så lenge foreldrenoden til den nye noden er større en noden, bytter vi om på disse.

#### ii)

[TEGNING]

### 3c)

#### i

For å fjerne et tall bytter man om rotnoden og den siste noden i heapen. Den tidligere rotnoden tas så ut.

Viderer bytter man plass på noden som ble flyttet og den minste av barna derese, så lenge et av barnene er mindre enn noden selv.

#### ii

[TEGNING]

### 3d)

#### i

En minimumsheap lagres ved å for hver node finne IDen dens. Deretter legges noden til i Arrayet på den tilsvarende plassen.

Node-IDene finnes slik:
    - NodeId er posisjon - 1
    - Rotnoden har posisjon 1
    - For hver node gjelder det at posisjonen til venstre barn er posisjon \* 2
    - For hver node gjelder at posisjonen til høyre barn er (posisjon \* 2) + 1

I praksisk trenger man ikke å gjøre denne utregningen, da en minimumsheap er et komplett tre. Dette gjør at vi i stedet kan traversere treet i nivåorden, og legge inn hver node som neste element i listen.

#### ii

[3, 4, 5, 6, 5, 7, 6]


## Oppgave 4

### 1

void remove(int index) {
    if (index == 0) {
        removeFirst();
    }
    else if (index == size-1) {
        removeLast();
    }
    else {
        Node curr_node;
    if (index > size/2) {
        curr_node = head;

        for (int i = 0; i <= index; i++) {
            curr_node = curr_node.next;
        }

    }
    else {
        curr_node = tail;

        for (int i = size-1; i >= index; i--) {
            curr_node = curr_node.next;
        }
    }

    curr_node.prev.next = curr_node.next;
    curr_node.next.prev = curr_node.prev;

    size--;
}

### 2

void remove(char value) {
    Node curr_node = head;

    while (not curr_node.value.equal(value)) {
        curr_node = curr_node.next;
    }

    curr_node.prev.next = curr_node.next;
    curr_node.next.prev = curr_node.prev;

    size--;
}


## Oppgave 5

### 5a)

Et balansert binært søketre er et søketre som automatisk justerer antall nivæer og plasseringen av noder for å unngå et ubalansert tre.

### 5b)

[TEGNING]


