package edu.vinu.TournamentDrawPlatform.exceptions.custom;

public class InternalServerErrorException extends RuntimeException{
    public InternalServerErrorException(String message){
        super(message);
    }
}
