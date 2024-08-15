import './Tag.css';
const Tag = ({tagname}) => {
    return(
        <button className="tag">+{tagname}</button>
    );

}


export default Tag;