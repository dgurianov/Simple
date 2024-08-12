import axios from "axios";
import { useEffect, useState } from "react";

const Search = () => {
    const[what, setWhat] = useState('cat');
    const[results, setResults] = useState([]);

    //useEffect does not allow to call async await directly. Next 3 options available:

    useEffect(() => {
        //Declare function with await and immediately call it
        /*
        const search = async() => {await axios.get('url');}
        search();

        OR

        declare anon  lambda and call

         ( async () => { 
            const {data} = await axios.get('url' , { params: { action: 'query' } });
            setResults(data.query.search);
                        }
        )();
        

        OR
        use the promise . Least often used

        axios.get('url')
        .then((response)=>{console.log(response.data);})

        
        */

    const search = async() => {
        const {data} = await axios.get('https://en.wikipedia.org/w/api.php', {
            params:{
                action: 'query',
                list: 'search',
                origin: '*',
                format: 'json',
                srsearch: what,
            }
        });
        setResults(data.query.search);
    };

    if(what && !results.length){
        search();

    }else {
        const timeoutId = setTimeout(() => {
            if(what) {search();}
        },1000);

        return () => {clearTimeout(timeoutId)};
    }
    
    },[what]);
    //End of useEffects

    const renderedResults = results.map((result) => {
        return(
            <div key={result.pageid}>
                <div>
                    <div>
                        {result.title}
                    </div>
                    {result.snippet}
                </div>

            </div>
        )
    });


    return(
        <div>
            <div>
                <div>
                    <label>Enter search term</label>
                    <input value={what}
                    onChange={e=> setWhat(e.target.value)}/>
                </div>
            </div>
            <div>
                {renderedResults}
            </div>
        </div>
    );
};


export default Search;