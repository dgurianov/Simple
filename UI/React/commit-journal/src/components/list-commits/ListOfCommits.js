import mockData from '../Stub.json';
import Commit from './Commit';

const ListOfCommits = () => {
    return (mockData.commits.map((element)=>{
       
        return(
            <div>
                <Commit key={element.id} element={element}/>
                </div>
        ) 

    })

    );
    

}

export default ListOfCommits;